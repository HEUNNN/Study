package ch7;

public class RepairableTest {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Dropship dropship = new Dropship();
        Marine marine = new Marine();

        SCV scv = new SCV();

        scv.reapair(tank);
        scv.reapair(dropship);
        //scv.repair(marine); // 오류 발생 -> Marine은 Repairable interface를 구현하지 않았고, SCV클래스의 repair 메서드는 Repairable 타입의 매개변수를 받기 때문에 오류가 발생한다.
    }
}
interface Repairable {}
class Unit2 {
    int hitPoint;
    final int MAX_HP;
    public Unit2(int hp) { // Unit2 class 생성자
        MAX_HP = hp;
    }
}
class GroundUnit extends Unit2 {
    public GroundUnit(int hp) {
        super(hp);
    }
}
class AirUnit extends Unit2 {
    public AirUnit(int hp) {
        super(hp);
    }
}
class Tank extends GroundUnit implements Repairable {
    public Tank() {
        super(150);
        hitPoint = MAX_HP;
    }
    public String toString() {
        return "Tank";
    }
}
class Dropship extends AirUnit implements Repairable {
    public Dropship() {
        super(125);
        hitPoint = MAX_HP;
    }
    public String toString() {
        return "Dropship";
    }
}
class Marine extends GroundUnit {
    public Marine() {
        super(40);
        hitPoint = MAX_HP;
    }
}
class SCV extends GroundUnit implements Repairable {
    public SCV() {
        super(60);
        hitPoint = MAX_HP;
    }
    public void reapair(Repairable r) {
        if(r instanceof Unit2) {
            Unit2 u2 = (Unit2)r; // Repairable 에 멤버변수가 선언되지 않았으므로 Unit2로 Downcasting을 하여 Unit2의 멤버변수인 hitPoint와 MAX_HP을 사용한다.
            while(u2.hitPoint != u2.MAX_HP) {
                u2.hitPoint++;
            }
            System.out.println(u2.toString() + "의 수리가 끝났습니다.");
        }
    }
}

