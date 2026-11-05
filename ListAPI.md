# List API (Abridged)
This abridged Map API contains documentation for the following methods:

- copyOf
- add
- remove (2 versions)
- sort
- stream
- toArray

## copyOf
    
    static <E> List<E> copyOf(Collection<? extends E> coll)

    Returns an unmodifiable List containing the elements of the given Collection, in its iteration order. The given Collection must not be null, and it must not contain any null elements. If the given Collection is subsequently modified, the returned List will not reflect such modifications.

    Implementation Note:

    If the given Collection is an unmodifiable List, calling copyOf will generally not create a copy.

    Type Parameters:

    E - the List's element type

    Parameters:

   coll - a Collection (such as another List) from which elements are drawn, must be non-null

    Returns:

    a List containing the elements of the given Collection

    Throws:

    NullPointerException - if coll is null, or if it contains any nulls
    
## add

    boolean add(E e)

    Appends the specified element to the end of this list (optional operation).

    Parameters:

    e - element to be appended to this list

    Returns:

    true (as specified by Collection.add(E))

    Throws:

    UnsupportedOperationException - if the add operation is not supported by this list

    ClassCastException - if the class of the specified element prevents it from being added to this list

    NullPointerException - if the specified element is null and this list does not permit null elements

    IllegalArgumentException - if some property of this element prevents it from being added to this list
            

## remove

    boolean remove(Object o)

    Removes the first occurrence of the specified element from this list, if it is present (optional operation). If this list does not contain the element, it is unchanged. More formally, removes the element with the lowest index i such that Objects.equals(o, get(i)) (if such an element exists). Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).

    Specified by:

    remove in interface Collection<E>

    Parameters:

    o - element to be removed from this list, if present

    Returns:

    true if this list contained the specified element

    Throws:

    ClassCastException - if the type of the specified element is incompatible with this list (optional)

    NullPointerException - if the specified element is null and this list does not permit null elements (optional)

    UnsupportedOperationException - if the remove operation is not supported by this list
            

## remove

    E remove(int index)

    Removes the element at the specified position in this list (optional operation). Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.

    Parameters:

    index - the index of the element to be removed

    Returns:

    the element previously at the specified position

    Throws:

    UnsupportedOperationException - if the remove operation is not supported by this list
    IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size()) 


## sort

    default void sort(Comparator<? super E> c)

    Sorts this list according to the order induced by the specified Comparator. The sort is stable: this method must not reorder equal elements.

    All elements in this list must be mutually comparable using the specified comparator (that is, c.compare(e1, e2) must not throw a ClassCastException for any elements e1 and e2 in the list).

    If the specified comparator is null then all elements in this list must implement the Comparable interface and the elements' natural ordering should be used.

    This list must be modifiable, but need not be resizable.

    Parameters:

    c - the Comparator used to compare list elements. A null value indicates that the elements' natural ordering should be used

    Throws:

    ClassCastException - if the list contains elements that are not mutually comparable using the specified comparator

    UnsupportedOperationException - if the list's list-iterator does not support the set operation

    IllegalArgumentException - (optional) if the comparator is found to violate the Comparator contract

## stream

    default Stream<E> stream()

    Returns a sequential Stream with this collection as its source.

    This method should be overridden when the spliterator() method cannot return a spliterator that is IMMUTABLE, CONCURRENT, or late-binding. (See spliterator() for details.)

    Implementation Requirements:

    The default implementation creates a sequential Stream from the collection's Spliterator.

    Returns:

    a sequential Stream over the elements in this collection

## toArray

    <T> T[] toArray(T[] a)

    Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array. If the list fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.

    Suppose x is a list known to contain only strings. The following code can be used to dump the list into a newly allocated array of String:

        String[] y = x.toArray(new String[0]);

    Type Parameters:

    T - the component type of the array to contain the collection
    
    Parameters:
    
    a - the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
    
    Returns:
    
    an array containing the elements of this list
    
    Throws:
    
    ArrayStoreException - if the runtime type of the specified array is not a supertype of the runtime type of every element in this list
    NullPointerException - if the specified array is null

