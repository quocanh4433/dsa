### Length of ArrayList
```java
List<Integer> list = new ArrayList<>();
int length = list.size(); // ✅
int length = list.length(); // Me ❌
```


### Check key inside HashMap
```java
Map<Integer, String> map = new HashMap<>();
boolean hasKey = map.containsKey(key); // ✅
boolean hasKey = map.containsKey(key); // Me ❌
```


### ArrayList<String> to String[]
```java
ArrayList<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Cherry");
// Cách chuyển ArrayList<String> sang String[]
String[] array = list.toArray(new String[list.size()]);
```


### String[] to ArrayList<String> 
```java
String[] array = {"Apple", "Banana", "Cherry"};
// Chuyển sang ArrayList
ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
```