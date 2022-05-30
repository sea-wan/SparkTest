package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


/**
 * Author: wanyingfei
 * Date: 2022/5/22 18:42
 * Description:
 * Version: 1.0
 */
object Transform_map {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_map")
    val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5),2)

    val mapRDD = rdd.map(
      num => {
        println("+++++++ "+ 2 * num)
        num * 3
      }
    )


    mapRDD.collect().foreach(println)

    sc.stop()

  }
}
