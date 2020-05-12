package shejimoshi.StrategeModel.Stratey_Mode;

public interface Fly {
    void fly();
}

interface GuaGua {
    void GuaGua();
}


class qucikfly implements Fly {

    @Override
    public void fly() {
        System.out.println("飞的快");
    }
}

class lowfly implements Fly {
    @Override
    public void fly() {
        System.out.println("飞的慢");
    }
}


class jianjiao implements GuaGua {
    @Override
    public void GuaGua() {
        System.out.println("叫声很大");
    }
}

class bujiao implements GuaGua {
    @Override
    public void GuaGua() {
        System.out.println("叫声很小");
    }
}