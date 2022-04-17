import kr.TPC.Animal;
import kr.TPC.Cat;
import kr.TPC.Dog;

public class TPC25 {
    public static void main(String[] args) {
        // 다형성 배열
        // Dog, Cat 저장할 배열을 생성할 때 동일한 DataType이 아니기 때문에 배열로 묶기가 힘들지만 부모 Class를 잘 활용하면 가능하다.
        Animal[] ani = new Animal[2];
        ani[0] = new Dog();
        ani[1] = new Cat();

        display(ani);
    }
    public static void display(Animal[] arr){ // 다형성 배열
        for (int i = 0; i < arr.length; i++) {
            arr[i].eat();
            if(arr[i] instanceof Cat){
                ((Cat)arr[i]).night();
            }
        }
    }
}
