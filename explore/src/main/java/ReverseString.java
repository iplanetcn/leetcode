public class ReverseString {
    public void reverseString(char[] s) {
        swap(s, 0);
    }

    public void swap(char[] str, int index) {
        if(index >= str.length / 2 || index > str.length - 1) {
            return;
        }

        char temp = str[index];
        str[index]=str[str.length-index-1];
        str[str.length-index-1]=temp;

        swap(str, ++index);
    }
}
