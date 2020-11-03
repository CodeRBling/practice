<h1>Thread Basics</h1>
<h3><a href="https://github.com/CodeRBling/practice/blob/dev/MultiThreading/src/com/practice/one/ThreadOne.java">Thread Creation</a></h3>
<p>Thread can be created in 3 ways</p>
<ol>
	<li>Implemention runnable interface</li>
	<li>Extending thread class</li>
	<li>Using anonymous class/functional interface</li>
</ol>
<h3><a href="https://github.com/CodeRBling/practice/blob/dev/MultiThreading/src/com/practice/one/MainClass.java">Starting thread execution</a></h3>
<p>Thread execution is started by calling <code>start()</code> method.</p>
<br>Note: Calling <code>run()</code> will start execution of <code>run()</code> method in the same thread no new thread will be created.
<h3><a href="https://github.com/CodeRBling/practice/blob/dev/MultiThreading/src/com/practice/one/MainClass.java">Waiting for thread</a></h3>
<p><code>join()</code> is used to make main thread wait for completion of thread from which join is called</p>
