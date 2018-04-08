package com.thoughtworks.collection;

public class SingleLinkIn implements SingleLink<Integer>{
    private SNode head = new SNode(0);
    private int size = 0;

    public int getSize() {
        return this.size;
    }
    public SingleLinkIn(){
        head = new SNode();
    }
    @Override
    public Integer getHeaderData(){
        return this.head.getData();
    }
    @Override
    public Integer getTailData(){
        SNode p =head;
        while (p.getNextNode()!=null){
            p=p.getNextNode();
        }
        return p.getData();
    }
    @Override
    public int size(){
        return getSize();
    }
    @Override
    public boolean isEmpty(){
        return head.getNextNode()==null;
    }
    @Override
    public boolean deleteFirst(){
        SNode p ;
        boolean flag = false;
        if(head.getNextNode()==null){
            return false;
        }
        p = head.getNextNode();
        if(p.getNextNode()!=null){
            head.setNextNode(p.getNextNode());
            flag = true;
        }
        this.size--;
        return flag;
    }
    @Override
    public boolean deleteLast(){
        SNode p=head.getNextNode();
        SNode pre = head;
        while (p.getNextNode()!=null){
            pre = pre.getNextNode();
            p = p.getNextNode();
        }
        pre.setNextNode(null);
        this.size--;
        return true;
    }
    @Override
    public void addHeadPointer(Integer item){
        SNode p = head.getNextNode();
        SNode newNode = new SNode(item);
        head.setNextNode(newNode);
        newNode.setNextNode(p);
        this.size++;
    }
    @Override
    public void addTailPointer(Integer item){
        SNode p = this.head;
        SNode newNode = new SNode(item);
        if(this.size == 0){
            this.head.setNextNode(newNode);
            newNode.setNextNode(null);
        }
        else {
            while (p.getNextNode() != null) {
                p = p.getNextNode();
            }
            p.setNextNode(newNode);
            newNode.setNextNode(null);
        }
        this.size++;
    }
    @Override
    public Integer getNode(int index){
        int i = 1;
        SNode p = head.getNextNode();
        if(index<=0||index>this.size||p==null){
            return null;
        }
        while (p!=null&&i<index){
            p =  p.getNextNode();
            i++;
        }
        if(i>index||p==null){
            try {
                throw new Exception("第"+index+"个元素不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int result =  p.data;
        return result;
    }
    public void printLinkList(){
        int length = this.size;
        if(length == 0){
            System.out.println("空链表");
            return;
        }
        SNode p = this.head.getNextNode();
        int find = 0;
        while (p!=null){
            System.out.println("第" + (++find)+"个节点："+p.getData());
            p = p.getNextNode();
        }
    }

}

