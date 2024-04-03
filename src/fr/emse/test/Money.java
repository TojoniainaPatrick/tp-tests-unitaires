package fr.emse.test;

public class Money implements IMoney{
	
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}
	
	public int amount() {
		return fAmount;
	}
	
	public String currency() {
		return fCurrency;
	}
	
	public IMoney add(IMoney m) {
		return m.addMoney(this);
	}
	
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        return fAmount == other.fAmount && fCurrency.equals(other.fCurrency);
    }
	
	@Override
    public IMoney addMoney(Money m) {
        if (currency().equals(m.currency())) {
            return new Money(amount() + m.amount(), currency());
        }
        return new MoneyBag(this, m);
    }

    @Override
    public IMoney addMoneyBag(MoneyBag mb) {
        return mb.addMoney(this);
    }

}
