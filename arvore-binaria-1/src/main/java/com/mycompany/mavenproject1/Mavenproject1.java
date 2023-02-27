/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author FelipeJhordan
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(23);
        tree.addElement(1);
        
        System.out.println("In order");
        tree.inOrder(tree.getRoot());
        
        System.out.println("Pre Order ");
        tree.preOrder(tree.getRoot());
        
        System.out.println("Pos Order");
        tree.posOrder(tree.getRoot());
    }
}


class Element <T> {
    private T value;
    private Element<T> left;
    private Element<T> right;
    
    public Element(T newValue) {
        this.value = newValue;
        this.left = null;
        this.right = null;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T newValue) {
        this.value = newValue;
    }

    public Element<T> getLeft() {
        return left;
    }

    public void setLeft(Element<T> left) {
        this.left = left;
    }

    public Element<T> getRight() {
        return right;
    }

    public void setRight(Element<T> right) {
        this.right = right;
    }
    
    
}

class Tree<T extends Comparable> {
       private Element<T>  root;
       
       public Tree() {
           this.root = null;
       }
       
       
       public Element<T> getRoot() {
            return this.root;
       }
       
       public void addElement(T value) {
           Element<T> newElement = new Element<>(value);
           
           if( root == null) {
               this.root = newElement;
               return;
           }
           
           Element<T> current = this.root;
           
           while(true) {
               if(newElement.getValue().compareTo(current.getValue()) == -1) {
                   if(current.getLeft() != null) {
                       current = current.getLeft();
                       continue;
                    }
                   current.setLeft(newElement);
                   break;
               }
               
               if(current.getRight() != null) {
                   current = current.getRight();
                   continue;
               }
               
               current.setRight(newElement);
               break;
           }
           
           
       }
       
       public void inOrder(Element<T> current) {
           
           if(current != null) {
                inOrder(current.getLeft());
                System.out.println(current.getValue());
                inOrder(current.getRight());
           }
       }
       
       public void preOrder(Element<T> current) {
           if(current != null) {
               System.out.println(current.getValue());
               preOrder(current.getLeft());
               preOrder(current.getRight());
           }
       }
       
        public void posOrder(Element<T> current) {
           if(current != null) {
               preOrder(current.getLeft());
               preOrder(current.getRight());
               System.out.println(current.getValue());
           }
       }
}   
