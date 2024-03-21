/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package eu.symmetrysought.raspberryjam.kts.dynamic.loader

import java.io.File
import javax.script.ScriptEngineManager

@Suppress("UNUSED_PARAMETER")
fun evaluate(arg: String): Int {
    val engine = ScriptEngineManager().getEngineByExtension("kts")!!

    print("> ")
    val res = engine.eval(arg)
    println(res)
    print("> ")

    return res as Int
}

fun fromFile(filename: String): String {
    val scriptFile = File(filename)
    println("Executing script $scriptFile")
    val engine = ScriptEngineManager().getEngineByExtension("kts")!!

    val fileContent = scriptFile.readText()
    val result = engine.eval(fileContent)

    return result as String
}
