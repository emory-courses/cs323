package utils;

public class MathUtils
{
    /**
     * @param beginIndex inclusive.
     * @param endIndex inclusive.
     * @return the middle index between the begin and end indices.
     */
    static public int getMiddleIndex(int beginIndex, int endIndex)
    {
        return beginIndex + (endIndex - beginIndex) / 2;
    }

    static public void main(String[] args)
    {
        System.out.println(getMiddleIndex(0, 10));
    }
}
