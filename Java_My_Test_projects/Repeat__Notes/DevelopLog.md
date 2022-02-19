## 开发者日志
-------
### 2022/2/19
**遇到的问题**
1. 设置icon的时候有问题，按钮的图标的能够正常显示，但是使用url
就可以正常使用。
~~~
---------------------- 可以正常显示-----------------------
URL url = getClass().getResource("/icon/***.png");
Icon icon = new Image(url);
JButton jButton = new JButton("test"):
jButton.setIcon(icon);
----------------------不可以正常显示----------------------
Icon icon = new Image("/icon/***.png");
JButton jButton = new JButton("test");
jButton.setIcon(icon);
~~~
2. 不懂怎么使用矢量图标，使用静态的png，不太好用，不能够设置大小