package fr.emse.test;

import java.util.Vector;

class MoneyBag implements IMoney{
	
	private Vector<Money> fMonies = new Vector<Money>();
	
	MoneyBag(Money m1, Money m2) {
			appendMoney(m1); 
			appendMoney(m2);
	}
	
	MoneyBag(Money bag[]) {
		for (int i = 0; i < bag.length; i++)
			appendMoney(bag[i]);
	}
	
	public MoneyBag() {
		// TODO Auto-generated constructor stub
	}

	private void appendMoney(Money m) {
		if (fMonies.isEmpty()) {
			fMonies.add(m);
		} 
		else {
			int i = 0;
			while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency()))))
				
				i++;
				if (i >= fMonies.size()) {
					fMonies.add(m);
				} 
				else {
					fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
				}
		}
	}
	
	public IMoney add(IMoney m) {
		return m.addMoneyBag(this);
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MoneyBag other = (MoneyBag) obj;
        return fMonies.equals(other.fMonies);
    }

    
    @Override
    public IMoney addMoney(Money m) {
        appendMoney(m);
        return simplify();
    }

    @Override
    public IMoney addMoneyBag(MoneyBag mb) {
        for (Money money : mb.fMonies) {
            appendMoney(money);
        }
        return simplify();
    }

    private MoneyBag simplify() {
        MoneyBag result = new MoneyBag();
        for (Money money : fMonies) {
            result.appendMoney(money);
        }
        return result;
    }
}
