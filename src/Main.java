
interface MensClothing {
    void dressMan();
}

interface WomensClothing {
    void dressWoman();
}

enum Size {
    XXS(32), XS(34), S(36), M(38), L(40);

    private int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public void getEuroSize() {
        System.out.println(euroSize);
    }

    public void getDescription() {
        if (this == XXS) {
            System.out.println("Это детский размер");
        } else {
            System.out.println("Взрослый размер");
        }
    }
}

abstract class Cloth {

    public Size size;
    public double cost;
    public String color;

    public Cloth(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }
}

class TShirt extends Cloth implements MensClothing, WomensClothing {
    public TShirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская футболка: размер - " + size + ", цена - $" + cost + ", цвет - " + color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская футболка: размер - " + size + ", цена - $" + cost + ", цвет - " + color);
    }
}

class Pants extends Cloth implements MensClothing, WomensClothing {
    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские штаны: размер - " + size + ", цена - $" + cost + ", цвет - " + color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женские штаны: размер - " + size + ", цена - $" + cost + ", цвет - " + color);
    }
}

class Skirt extends Cloth implements WomensClothing {
    public Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская юбка :размер - " + size + ", цена - $" + cost + ", цвет - " + color);
    }
}

class Tie extends Cloth implements MensClothing {
    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужской галстук: размер - " + size + ", цена - $" + cost + ", цвет - " + color);
    }
}

class Tailor {
    public void dressWoman(Cloth[] clothes) {
        System.out.println("Женская одежда:");
        for (Cloth clothing : clothes) {
            if (clothing instanceof WomensClothing) {
                ((WomensClothing) clothing).dressWoman();
            }
        }
    }

    public void dressMan(Cloth[] clothes) {
        System.out.println("Мужская одежда:");
        for (Cloth clothing : clothes) {
            if (clothing instanceof MensClothing) {
                ((MensClothing) clothing).dressMan();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TShirt t1 = new TShirt(Size.S, 26, "зеленый");
        Pants p = new Pants(Size.M, 12, "белый");
        Skirt s = new Skirt(Size.XXS,24, "красный");
        Tie t = new Tie(Size.S, 60, "желтый");
        Cloth[] clothes ={t1, p, s, t};

        Tailor tailor = new Tailor();
        tailor.dressWoman(clothes);
        System.out.println();
        tailor.dressMan(clothes);
        Size.XXS.getDescription();
        Size.L.getEuroSize();
    }
}
