import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class Counter extends StatefulWidget {
  const Counter({super.key, required this.title, required this.token});

  final String title;
  final String token;

  @override
  State<Counter> createState() => _CounterState();
}

class _CounterState extends State<Counter> {
  int _counter = 0;

  @override
  void initState() {
    super.initState();
    http.get(Uri.parse('http://192.168.31.222:8080/api/counter'), // localhost
            headers: {'Authorization': 'Bearer ${widget.token}'})
        .then((value) => setState(() {
              _counter = json.decode(value.body);
            }));
  }

  void _incrementCounter() {
    setState(() {
      _counter++;
      http.post(Uri.parse('http://192.168.31.222:8080/api/counter/increase'),
          headers: {'Authorization': 'Bearer ${widget.token}'});
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ),
    );
  }
}
