# JW03

## 代码理解

### 包理解

​	classloader下重写了自己的类加载器，能从图片中隐藏的字节码中加载类，加载失败时抛出ClassNotFoundException异常；

​	encoder提供了封装好的编码和解码方法，就是隐写术；

​	resources就是W02基础上把Scene更改为使用隐写术图中的排序方法.

### 类加载理解

​	Scene中首先调用ClassLoader的*loadClass( )*方法， 逐级委派查找后调用重载的*findClass( )*方法。

​	findClass( )方法本来是根据名称/位置去加载.class字节码然后转化为类，SteganographyClassLoader重写后，findClass将url地址*(ImageIO.read(url))*中存放的图片*(SteganographyEncoder(img))*中解码出的*(deodeByteArray( ))*隐藏的字节码转化为类*(ClassLoader.defineClass( ))*。

​	返回值上，该方法用了泛型Class<?>表示类型不确定的类，然后在Scene中将加载好的Class用*newInstance( )*方法实例化后强制类型转换为排序方法的接口Sorter型。