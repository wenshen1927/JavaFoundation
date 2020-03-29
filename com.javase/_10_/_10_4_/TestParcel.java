package _10_._10_4_;

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents contents = p.contents();
        Destination d = p.destination("WuHan");
        // PContent被设为private，不能用new实例化.
        // 这样就封装了具体类型，只暴露给客户端程序员一个接口，封装了细节。
//        p.new PContents()
    }
}
