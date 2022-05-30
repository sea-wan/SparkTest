package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 19:47
 * Description:
 * Version: 1.0
 */
object Transform_DoubleValue {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_DoubleValue")
    val sc = new SparkContext(sparkConf)

    //交集、并集、差集要求两个数据源类型一致
    //拉链操作两个数据源可以不一致

    val rdd1 = sc.makeRDD(List(1, 2, 3, 4, 5))
    val rdd2 = sc.makeRDD(List(3, 4, 5, 6, 7))
    val rdd3 = sc.makeRDD(List("5", "6", "7", "8", "9"))

    //交集
    val value1 = rdd1.intersection(rdd2)
    println(value1.collect().mkString(","))

    //并集
    val value2 = rdd1.union(rdd2)
    println(value2.collect().mkString(","))

    //差集
    val value3 = rdd1.subtract(rdd2)
    println(value3.collect().mkString(","))

    //拉链  ,要求两个数据源数量要相同
    val value4 = rdd1.zip(rdd2)
    val value5 = rdd1.zip(rdd3)
    println(value4.collect().mkString(","))
    println(value5.collect().mkString(","))

  }

}
