/**
    Box for T
*/
class Box<T> {

    private T content;

    public void put(T newContent) {
    	this.content = content;
    }

    public T get() {
        return this.content;
    }
}

// Don't change classes below
class Cake { }

class Pie { }

class Tart { }