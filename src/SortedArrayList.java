import java.util.ArrayList;

public class SortedArrayList<E> extends ArrayList<E> {//E 类似于一个模板 告诉程序当有具体的类型被输入的时候 替换函数中E的类型
    public SortedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public SortedArrayList() {
        super();
    }

    @Override
    public boolean add(E e) {
        super.add(e);

        int i,j;
        for(i=0;i<this.size();i++){
            for(j=1;j<this.size()-i;j++)
            {
                if(this.get(j-1).toString().compareTo(this.get(j).toString())>0){
                    E temp=this.get(j-1);
                    this.set(j-1,this.get(j));
                    this.set(j,temp);
                }
            }//this : 每一个对象通过this指针来访问自己的地址

        }//冒泡排序

        return true;
    }
}
