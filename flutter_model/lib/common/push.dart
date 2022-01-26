import 'package:flutter/material.dart';

class Push {
  static Future to(BuildContext context, Widget page) {
    return Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => page),
    );
  }

  static Future toName(BuildContext context, String pageName) {
    return Navigator.pushNamed(context, pageName);
  }
}
