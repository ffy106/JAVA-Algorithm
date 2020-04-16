package Test;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
}
class Linklist{
    Node head=null;
    //添加节点
    public void addNode(int data){
        //开辟一个新节点
        Node newNode=new Node(data);
        //判断当前链表是否为空
        if (head==null){  //如果当前链表为空
            head=newNode;     //将该节点赋值给头结点
        }else{          //否则头结点不为空,将临时节点newnode添加到链表之后
          Node tem=head;
            while(tem.next!=null){
                tem=tem.next;
            }
            tem.next=newNode;
        }
    }
    //打印链表中的元素
    public void print(Node head){
        //因为链表的表头是固定的
        Node tem=head;
        while(tem!=null){
            System.out.print(tem.data+"\t");
            tem=tem.next;
        }
    }
    public int length(){
        Node tem=head;
        int length=0;
        while(tem!=null){
            length++;
            tem=tem.next;
        }
        return length;
    }
}
class Solution extends Linklist {
    public Node oddEvenList(Node head) {
        //判断链表是否为空
        if(head==null) return null;
        //创建四个指针，代表奇链表的头和尾，偶链表的头和尾指针
        Node odd=head, evenHead=head.next,even=evenHead;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }}
public class NO725 {
    public static void main(String[] args) {
        Solution s=new Solution();
        s.addNode(1);
        s.addNode(2);
        s.addNode(3);
        s.addNode(3);
        s.addNode(2);
        s.addNode(1);
        System.out.println("原链表数据为：");
        s.print(s.head);
        s.oddEvenList(s.head);
        System.out.println("\n奇偶转变后链表为");
        s.print(s.head);
    }
}
