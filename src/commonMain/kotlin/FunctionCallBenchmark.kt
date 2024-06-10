package org.example

import kotlinx.benchmark.*

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 5)
@Measurement(iterations = 10, time = 5)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
open class FunctionCallBenchmark {
    var idx = 0

    private fun nextInt(): Int {
        return idx++
    }

    @Benchmark
    fun freeFunctionCall(bh: Blackhole) {
        bh.consume(freeFunction(nextInt()))
    }

    @Benchmark
    fun objectFunctionCall(bh: Blackhole) {
        bh.consume(SomeApi.callOnObject(nextInt()))
    }
}
