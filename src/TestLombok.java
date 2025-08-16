import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Lombok{
    private String name;


}

public class TestLombok {
    public static void main(String[] args) {
        Lombok obj = new Lombok();
        obj.setName("Ankit");
        System.out.println(obj.getName());
    }

}