public class MathUtils {

    // 1. Phương thức tìm USCLN (Ước số chung lớn nhất)
    public int findUSCLN(int a, int b) {
        // Điều kiện kết hợp: Cả 2 số không được đồng thời bằng 0
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Cả hai số không thể đồng thời bằng 0");
        }

        // BUG CỐ Ý: Quên không lấy trị tuyệt đối (Math.abs) cho a và b
        // Lỗi này sẽ gây ra vòng lặp vô hạn nếu đầu vào là số âm.
        // Lẽ ra phải có: a = Math.abs(a); b = Math.abs(b);

        if (a == 0) return b;
        if (b == 0) return a;

        // Sử dụng If/Else và While để đạt tiêu chí Branch Coverage
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    // 2. Phương thức tìm BSCNN (Bội số chung nhỏ nhất)
    public int findBSCNN(int a, int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Cả hai số không thể đồng thời bằng 0");
        }
        if (a == 0 || b == 0) return 0;
        return (Math.abs(a) / findUSCLN(Math.abs(a), Math.abs(b))) * Math.abs(b);
    }

    // 3. Phương thức kiểm tra 2 số nguyên tố cùng nhau (USCLN == 1)
    public boolean isCoprime(int a, int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Cả hai số không thể đồng thời bằng 0");
        }
        return findUSCLN(Math.abs(a), Math.abs(b)) == 1;
    }
}
