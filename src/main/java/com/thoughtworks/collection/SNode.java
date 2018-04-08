package com.thoughtworks.collection;

public class SNode {
    public Integer data;
    private SNode nextNode;
    public SNode(){}
    public  SNode(Integer data){
        this.data = data;
        this.nextNode = new SNode();
    }
    public Integer getData(){
        return data;
    }
    public void setData(Integer data){
        this.data = data;
    }
    public SNode getNextNode(){
        return nextNode;
    }
    public void setNextNode(SNode nextNode) {
        this.nextNode = nextNode;
    }
}

