### Chuyển String s = "123" sang số 
```java
int num = Integer.parseInt(s) // -> trả về kiểu int
int num = Integer.valueOf(s) // -> trả về wrapper class Integer

Stack<Integer> stack = new Stack<>();
stack.push(Integer.parseInt(s)) // -> autoboxing int -> Integer ⚠️
stack.push(Integer.valueOf(s)) ✅
```

### Thêm StringBuilder onto List<String>
```java
StringBuilder s = "String"
List<String> result = new ArrayList<>();

result.add(s.toString()) ✅
result.add(s) // ❌ error: incompatible types: StringBuilder cannot be converted to String
```


