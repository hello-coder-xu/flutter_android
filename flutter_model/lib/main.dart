import 'package:flutter/material.dart';
import 'package:flutter_model/page/goods_detail_page.dart';
import 'package:flutter_model/page/goods_list_page.dart';
import 'package:flutter_model/page/home_page.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      // initialRoute: '/',
      routes: {
        '/': (context) => const HomePage(),
        '/goods_list': (context) => const GoodsListPage(),
        '/goods_detail': (context) => const GoodsDetailPage(),
      },
    );
  }
}
