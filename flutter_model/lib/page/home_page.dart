import 'package:flutter/material.dart';
import 'package:flutter_model/common/push.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('我是首页'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              child: const Text('商品列表'),
              onPressed: () {
                Push.toName(context, '/goods_list');
              },
            ),
            ElevatedButton(
              child: const Text('商品详情'),
              onPressed: () {
                Push.toName(context, '/goods_detail');
              },
            ),
            ElevatedButton(
              onPressed: () {},
              child: const Text('退出'),
            ),
          ],
        ),
      ),
    );
  }
}
