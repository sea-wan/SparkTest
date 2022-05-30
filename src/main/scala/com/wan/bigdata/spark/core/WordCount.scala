package com.wan.bigdata.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/7 16:28
 * Description:
 * Version: 1.0
 */
object WordCount {
  def main(args: Array[String]): Unit = {
    //创建SparkConf对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

    //创建SparkContext对象,上下文对象,该对象是Spark的核心,
    val sc = new SparkContext(sparkConf)

    //读取文件
    val fileRdd = sc.textFile("/Users/wanyingfei/Desktop/Untitled Export.txt")

    //切分单词
    val wordRdd = fileRdd.flatMap(_.split("\t"))

    //转换数据结构
    val wordToOneRdd = wordRdd.map((_, 1))

    //聚合
    val wordToSumRdd = wordToOneRdd.reduceByKey(_ + _)

    //将转换后的数据采集到内存中
    val wordToSumArr = wordToSumRdd.collect()

    //打印
    wordToSumArr.foreach(println)

    //关闭资源
    sc.stop()

  }
}
