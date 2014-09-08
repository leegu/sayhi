package stu.lee.sayhi.util;

import android.content.Context;

public class CanvasHelper {

	// android��dip��dp��px��sp����Ļ�ܶ�
	//
	// 1. dip: device independent pixels(�豸��������).
	// ��ͬ�豸�в�ͬ����ʾЧ��,������豸Ӳ���йأ�һ������Ϊ��֧��WVGA��HVGA��QVGA �Ƽ�ʹ���� ��������������ء�
	// ����Ҫ�ر�ע��dip����Ļ�ܶ��йأ�����Ļ�ܶ���������Ӳ���йأ�Ӳ�����ò���ȷ���п��ܵ���dip����������ʾ������Ļ�ܶ�Ϊ160����ʾ���ϣ�1dip=1px����ʱ����������Ļ�ֱ��ʺܴ���480*800��������Ļ�ܶ�û����ȷ���ñ���˵����160����ô���ʱ����ʹ��dip�Ķ�����ʾ�쳣������������ʾ��С��
	// dip�Ļ��㣺
	// dip��value��=(int) (px��value��/1.5 + 0.5)
	// 2. dp: �ܼ򵥣���dip��һ���ġ�
	// 3. px: pixels(����)����ͬ���豸��ͬ����ʾ����ʾЧ������ͬ�ģ����Ǿ������أ��Ƕ��پ���Զ�Ƕ��ٲ���ı䡣
	// 4. sp: scaled pixels(�Ŵ�����). ��Ҫ����������ʾbest for textsize��
	//
	// ��ע: ����google���Ƽ�������ͳһʹ��dip������ͳһʹ��sp
	// �ٸ���������px��dip��
	// px�������أ������px,�ͻ���ʵ�����ػ����ȸ���ɣ��û�һ������Ϊ240px�ĺ��ߣ���480���ģ�����Ͽ�����һ�����������320���ģ�����Ͽ�����2��3�������ˡ�
	// ��dip�����ǰ���Ļ�ĸ߷ֳ�480�֣���ֳ�320�֡���������һ��160dip�ĺ��ߣ���������320��480��ģ�����ϣ�����һ�����ĳ��ȡ�

	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

}
