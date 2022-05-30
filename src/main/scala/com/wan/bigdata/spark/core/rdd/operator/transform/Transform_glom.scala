package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/24 16:27
 * Description:
 * Version: 1.0
 */
object Transform_glom {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_glom")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 2)
    rdd.collect().foreach(println)
    val value = rdd.glom()

    val value2 = rdd.glom().map(
      array =>{
        array.max
      }
    )

    value2.collect().foreach(println)
    println(value2.collect().sum)
    value.collect().foreach(datas => println(datas.mkString(",")))
    sc.stop()
  }
}
