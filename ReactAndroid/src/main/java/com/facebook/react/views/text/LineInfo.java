package com.facebook.react.views.text;

/**
 * Created by henrytao on 7/8/17.
 */

class LineInfo {

  private int mDefaultFontSize = ReactTextShadowNode.UNSET;

  private int mFontSize = ReactTextShadowNode.UNSET;

  private float mLineHeight = Float.NaN;

  LineInfo(int fontSize, float lineHeight) {
    mFontSize = fontSize;
    mLineHeight = lineHeight;
  }

  int getComputeFontSize() {
    return mFontSize != ReactTextShadowNode.UNSET ? mFontSize : mDefaultFontSize;
  }

  float getComputeLineHeight() {
    int fontSize = getComputeFontSize();
    if (fontSize == ReactTextShadowNode.UNSET) {
      return Float.NaN;
    }
    return !Float.isNaN(mLineHeight) ? mLineHeight : fontSize * 1.2f;
  }

  float getLineSpacing() {
    int fontSize = getComputeFontSize();
    float lineHeight = getComputeLineHeight();
    return !Float.isNaN(lineHeight) ? lineHeight - fontSize : 0;
  }

  void merge(LineInfo lineInfo) {
    mFontSize = Math.max(lineInfo.mFontSize, mFontSize);
    mLineHeight = Float.isNaN(mLineHeight) ? lineInfo.mLineHeight :
      Math.max(Float.isNaN(lineInfo.mLineHeight) ? mLineHeight :lineInfo.mLineHeight, mLineHeight);
  }

  void setDefaultFontSize(int defaultFontSize) {
    mDefaultFontSize = defaultFontSize;
  }
}
