package ticktacktoe.array;

public class ArrayFactory <T> {
    private int size;
    private T[] objects;

    public ArrayFactory (){
        objects = (T[]) new Object[size];
    }

    public void add(T object){
        if (size()==0){
            size++;
            objects = (T[]) new Object[size*2];
//            System.out.println("the size of object is: "+objects.length);
            objects[0]=object;
        }else{
            if (size<objects.length){
//                System.out.println("the array is not full yet");
                objects[size] = object;
                size++;
            }else {
                int newSize = size*2;
                T[] holder = (T[]) new Object[newSize];
                for (int i=0;i<size;i++){
                    holder[i] = objects[i];
                }
                String s = holder.toString();
                holder[size] = object;
                objects = holder;
                size++;
            }
        }
    }

    public T get(int i){
        return objects[i];
    }

    public int indexOf(T object){
        int counter=-1;
        for (int i=0;i<size;i++){
            if (objects[i].equals(object)){
                counter =  i;
                i = size;
            }
        }
        return counter;
    }

    public int size() {
        return size;
    }

    public void remove(T object){
        remove(indexOf(object));
    }

    public void remove(int i){
        if (size()==1){
            size--;
            objects = (T[]) new Object[size];
        }else{
            int newSize = size-1;
            int helper =0 ;
            T[] holder = (T[]) new Object[newSize];
            for (int y=0;y<newSize;y++){
                if (y!=i){
                    holder[y] = objects[y+helper];
                }else {
                    holder[y] = objects[y+1];
                    helper=1;
                }
            }
            objects = holder;
            size--;
        }
    }

    public boolean contains(T object){
        return (indexOf(object)>=0);
    }
    public boolean isIdentical( ArrayFactory<T> box1){
        ArrayFactory<T> holder1 = box1;
        int initialSize = holder1.size;
        boolean truth = false;
        if (size == holder1.size()){
            for (int i=0;i<size;i++){
                if(holder1.contains(get(i)) && holder1.size != 0){
                    holder1.remove(get(i));
                }else {
                    i = size;
                }
            }
            if ((size == initialSize)&&(holder1.size==0)){
                truth = true;
            }
        }
        return truth;
    }
    public void set(int i,T object){
        if (i<size){
            objects[i] = object;
        }
    }

    public String toString() {
        String st = "[";
        for (int i=0;i<size-1;i++){
            st=st+objects[i]+", ";
        }
        return st+objects[size-1]+"]";
    }
}
