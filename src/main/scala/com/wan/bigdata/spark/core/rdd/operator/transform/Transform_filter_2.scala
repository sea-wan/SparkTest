package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 16:00
 * Description:
 * Version: 1.0
 */
object Transform_filter_2 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_filter_2")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile("datas/apache.log")
    rdd.filter(
      line => {
        val datas = line.split(" ")
        val time = datas(3)
        time.startsWith("17/05/2015")
      }
    ).collect().foreach(println)

    sc.stop()
  }

}
