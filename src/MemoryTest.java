import java.util.HashMap;

/**
 * @author bertking
 * @date 2020/2/13
 */
public class MemoryTest {
    public static void main(String[] args) {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length / 1024);
//        System.gc();

        int hashCode = placeHolder.hashCode();
        System.out.println("hashCode:"+Integer.toBinaryString(hashCode));

        int code = hashCode >>> 16;
        System.out.println("右移16位:"+Integer.toBinaryString(code));

        System.out.println("tableSizeFor："+tableSizeFor(25));

        System.out.println("isNaN:"+Float.isNaN(-4.0f));


        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(null,null);
        hashMap.put("hello",null);
        System.out.println(hashMap);

        // 无限自增1
        for (int binCount = 0; ; ++binCount) {
            System.out.println("bincount:"+binCount);
        }

    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 100) ? 100 : n + 1;
    }





}
