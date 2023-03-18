package shangguigu.d02_nodeList;

/**
 * @Author: Patrick
 * @Date: 2023-03-09-15:59
 * @Description:
 */
public class SingleLinkedNode {
    private int no;
    private String name;
    private SingleLinkedNode next;

    public SingleLinkedNode(int no, String name){

        this.no = no;
        this.name = name;

    }

    @Override
    public String toString() {
        return "SingleLinkedNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
