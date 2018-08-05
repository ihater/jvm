package test15;
/**
 *	大对象和长期存活的对象：	
 *		多大才是大对象
 *		活多久才叫长期存活 （-XX:MaxTenuringThreshold）
 *
 *	第一次执行垃圾回收，Eden区域的数据存到Survivor中，并触发一个Age计数器
 *	每经历过一次GC，还能存活，Age 就会 +1 +1 +1 +1 +1 +1，达到 15 就会放到 老年代
 *
 *
 *	空间分配担保（-XX：+HandlePromotionFailure）
 *		如果新生代区域的内存不够用了，就会向老年代借内存，就叫空间分配担保
 *		新生代不够存的时候，要先检测 老年代的内存，够不够存新生代所有的存活数据
 *		接着，还要检测，HandlePromotionFailure有么即有开启	
 *		-XX：-HandlePromotionFailure 就是关闭
 *
 *		老年代，还会计算之前老年代可用空间的平均大小，再根据当前老年代可用内存的大小进行比较
 *		可用的比平均值大，就证明空间充足
 *	
 */
public class Info {

}
