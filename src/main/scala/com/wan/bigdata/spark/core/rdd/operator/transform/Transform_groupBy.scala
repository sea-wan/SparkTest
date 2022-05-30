package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

import java.text.SimpleDateFormat

/**
 * Author: wanyingfei
 * Date: 2022/5/29 22:33
 * Description:
 * Version: 1.0
 */
object Transform_groupBy {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_groupBy")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile("datas/apache.log")

    val rdd2 = sc.parallelize(List(1,2,3,4,5),2)
    val timerdd = rdd.map(
      line => {
        val datas = line.split(" ")
        val time = datas(3)
        val sdf = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss")
        val date = sdf.parse(time)
        val sdf1 = new SimpleDateFormat("HH")
        val hour = sdf1.format(date)
        (hour, 1)
      }
    ).groupBy(_._1)

    val value = timerdd.map {
      case (hour, iter) =>
        (hour, iter.size)
    }

    val value1 = rdd2.groupBy(_ % 2 != 0)

    value.collect().foreach(println)

    value1.collect().foreach(println)
    sc.stop()
  }
}
