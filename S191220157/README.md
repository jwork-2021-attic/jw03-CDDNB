# JW03

## 代码理解

### 包理解

​	classloader下重写了自己的类加载器，能从图片中隐藏的字节码中加载类，加载失败时抛出ClassNotFoundException异常；

​	encoder提供了封装好的编码和解码方法，就是隐写术；

​	其他就是W02基础上把Scene更改为使用隐写术图中的排序方法.

### 类加载理解

​	Scene中首先调用ClassLoader的*loadClass( )*方法， 类加载器先各自看内存中是否有已加载的类，若没有则逐级向上委派查找。若example中编译生成了Sorter的.class文件，则该排序方法的类能被Application Class Loader找到；若没有.class文件，则类加载器返回null，然后调起findClass( )。这个方法在Steganography中重载，从隐写术图中获取类。

​	findClass( )方法本来是根据名称/位置去加载.class字节码然后转化为类，SteganographyClassLoader重写后，findClass将url地址*(ImageIO.read(url))*中存放的图片*(SteganographyEncoder(img))*中解码出的*(deodeByteArray( ))*隐藏的字节码转化为类*(ClassLoader.defineClass( ))*。

​	返回值上，该方法用了泛型Class<?>表示类型不确定的类，然后在Scene中将加载好的Class用*newInstance( )*方法实例化后强制类型转换为排序方法的接口Sorter型。

## 自选方法

快速排序图片URL：https://github.com/jwork-2021/jw03-CDDNB/blob/main/example.QuickSorter.png

![image](https://github.com/jwork-2021/jw03-CDDNB/blob/main/example.QuickSorter.png)

选择排序图片URL：https://github.com/jwork-2021/jw03-CDDNB/blob/main/example.SelectSorter.png

![image](https://github.com/jwork-2021/jw03-CDDNB/blob/main/example.QuickSorter.png)

快速排序动画：[![asciicast](https://asciinema.org/a/qRBXyyysWVr95pP6yKvtSekaQ.svg)](https://asciinema.org/a/qRBXyyysWVr95pP6yKvtSekaQ)

选择排序动画：[![asciicast](https://asciinema.org/a/VyLbOvvrYejgcAKk9t5eiPMy2.svg)](https://asciinema.org/a/VyLbOvvrYejgcAKk9t5eiPMy2)

选用时欣191220097的图片（直接发图给我了，于是把她的图保存在自己的工作区下）![image](https://github.com/jwork-2021/jw03-CDDNB/blob/main/S191220157/example.SelectSorter.png)

可以实现排序