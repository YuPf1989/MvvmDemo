package com.rain.mvvmdemo.test

import kotlinx.coroutines.*

/**
 * Author:rain
 * Date:2019/3/22 15:17
 * Description:
 * 协程更像是一个定时执行的装置，协程的执行时机是当前线程（主协程）阻塞的时候（否则一直处于挂起状态），协程的生命周期与当前线程有关，并且一个线程可以有多个协程
 * 1. launch表示开启一个协程，并挂起，协程以外的函数先执行
 * 2. Thread.sleep 与 delay的区别：前者阻塞当前线程，后者不阻塞
 * 3. 当协程所在的线程执行完毕时，那么协程将被回收（不管有没有执行完毕），所以会在线程中添加阻塞保证jvm的存活
 * 4. runBlocking<Unit> { …… } 表示协程构建器，其作用域中启动的所有协程都执行完毕后才会结束
 *
 */
object TestK {
//    @JvmStatic
//    fun main(args: Array<String>) = runBlocking {
//        println("start")
//
//        // 表示开启一个协程
//        launch {
//            delay(200)
//            println("launch")
//        }
//
//        launch {
//            delay(600)
//            println("launch2")
//        }
//
//        // 创建一个新的协程作用域，等待所有子协程执行完毕时不会阻塞当前线程
//        coroutineScope {
//            launch {
//                delay(500L)
//                println("Task from nested launch")
//            }
//
//            delay(100L)
//            println("Task from coroutine scope")
//        }

//        async {
//            repeat(10){
//                delay(2000)
//                println("task1")
//            }
//        }
//
//        async {
//            repeat(10){
//                delay(200)
//                println("task2")
//            }
//        }

//        Thread.sleep(2000)
//        delay(1000)
//        println("stop ")

//        val job = launch {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ...")
//                for (j in 1.. 100000){
//                println("J:$j")
//            }
//                delay(5L)
//            }
//        }
//        delay(1L) // 延迟一段时间
//        println("main: I'm tired of waiting!")
//        job.cancel() // 取消该任务
////        job.join() // 等待任务执行结束
//        println("main: Now I can quit.")
//    }

    @JvmStatic
    fun main(args: Array<String>) {
//        println("start")
//        GlobalScope.launch {
//            delay(1000)
//            println("launch")
//        }
//        println("main...")
//        // 阻塞当前线程2s
////        Thread.sleep(2000)
//        // 调用runBlocking的主线程会一直阻塞到其中的协程执行完毕
////        runBlocking {
////            delay(2000)
////            println("runBlocking")
////        }
//        Thread.sleep(2000)
//        println("stop")

        val list = List(1000) {
            println("i:$it")
            it
        }
        list.forEach {
            println("it$it")
        }
    }
}