package _10_._10_5_;

/**
 * 在任意域里创建内部类（这样做有什么意义吗？封装类的可见性？）
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            // 虽然TrackingSlip在if语句里，但是并不是说该类的创建是有条件的，它其实与外部类一起编译过了。
            // 但是仅在if这个域里面可用，其他地方不可用
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
            System.out.println(s);
        }
        // 在域之外，不能创建内部类对象
//        TrackingSlip ts = new TrackingSlip("slip");
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
