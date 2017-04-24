= JVM参数配置 =
参考文章：http://www.cnblogs.com/wlzjdm/p/6725246.html[JVM参数]
1. -Xms20m 设置最小堆大小为20M
2. -Xmx20m 设置最大堆大小为20M（当它与最小堆一样大的时候，表示禁止自动扩展）
3. -XX:+HeapDumpOnOutOfMemoryError 当发生OutOfMemoryError的时候打印Dump信息
