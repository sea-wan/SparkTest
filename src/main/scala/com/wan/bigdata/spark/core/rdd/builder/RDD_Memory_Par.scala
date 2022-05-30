package com.wan.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/22 17:35
 * Description:
 * Version: 1.0
 */
object RDD_Memory_Par {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("RDD_Memory_Par")
    val sc = new SparkContext(sparkConf)

    //从集合中创建RDD
    val rdd1 = sc.makeRDD(List(1, 2, 3))
    val rdd2 = sc.parallelize(List(4, 5, 6))
    val rdd3 = sc.parallelize(List(7, 8, 9), 3)

    //从文件中创建RDD
    val rdd4 = sc.textFile("datas/Untitled Export.txt", 3)

    rdd1.saveAsTextFile("output/rdd1")
    rdd2.saveAsTextFile("output/rdd2")
    rdd3.saveAsTextFile("output/rdd3")

    rdd4.saveAsTextFile("output/rdd4")

    rdd1.collect().foreach(println)

    sc.stop()

  }
}
