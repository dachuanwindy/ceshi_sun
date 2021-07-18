package shejimoshi.Factory_Mode.factory2;

/**
 * DESC:接口泛型,解决返回值为多种类型的情况
 *
 * @author :IRead
 * @date 2021/7/2-09:27
 */

public interface IRead<T> {

    /**
     * 实现
     *
     * @param in
     * @return
     */
    T read(String in);
}
