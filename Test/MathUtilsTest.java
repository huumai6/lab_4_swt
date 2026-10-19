import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class MathUtilsTest {
    MathUtils math = new MathUtils();

    @Test // TC01: a=15, b=10 -> Kết quả = 5 (Bình thường)
    public void testUSCLN_TC01() {
        assertEquals(5, math.findUSCLN(15, 10));
    }

    @Test // TC02: a=14, b=21 -> Kết quả = 7 (Bình thường)
    public void testUSCLN_TC02() {
        assertEquals(7, math.findUSCLN(14, 21));
    }

    @Test // TC03: a=-25, b=15 -> Kết quả mong đợi = 5 (Abnormal - Cố tình để Fail)
    public void testUSCLN_TC03() {
        // Test này SẼ THẤT BẠI do timeout (vòng lặp vô hạn) -> Ghi vào DefectLog
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            assertEquals(5, math.findUSCLN(-25, 15));
        });
    }

    @Test // TC04: a=0, b=12 -> Kết quả = 12 (Boundary)
    public void testUSCLN_TC04() {
        assertEquals(12, math.findUSCLN(0, 12));
    }

    @Test // TC05: Cả 2 số bằng 0 -> Phải báo lỗi (Exception)
    public void testUSCLN_TC05() {
        assertThrows(IllegalArgumentException.class, () -> {
            math.findUSCLN(0, 0);
        });
    }
}