import 'package:flutter/material.dart';
import 'package:flutter_model/common/push.dart';

class GoodsListPage extends StatefulWidget {
  const GoodsListPage({Key? key}) : super(key: key);

  @override
  _GoodsListPageState createState() => _GoodsListPageState();
}

class _GoodsListPageState extends State<GoodsListPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('我是商品列表'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              child: const Text('商品详情'),
              onPressed: () {
                Push.toName(context, '/goods_detail');
              },
            ),
          ],
        ),
      ),
    );
  }
}
