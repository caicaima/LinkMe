package com.zhen.linkme;

import java.io.File;
import java.io.FileNotFoundException;
import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private static final int IMAGE_REQUEST_CODE = 0;
	private static final int CAMERA_REQUEST_CODE = 1;
	private static final int RESIZE_REQUEST_CODE = 2;

	private static final String IMAGE_FILE_NAME = "header.jpg";

	private ImageView men_view;
	private ImageView women_view;
	private ImageView mImageHeader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);

		men_view = (ImageView) findViewById(R.id.men_view);
		women_view = (ImageView) findViewById(R.id.women_view);
		mImageHeader = (ImageView) findViewById(R.id.reg_pho);

	}

	public void onclick(View view) {
		// ��ȡ�����id
		int id = view.getId();

		// ������ļ���
		switch (id) {
		case R.id.reg_pho:
			// �������ע��
			AddHeadImage();

			break;

		case R.id.come_back:
			// ���ص�¼���棨ActionBar�ķ���ͼ�꣩
			
			RegisterActivity.this.finish();

			break;

		case R.id.men_view:
			//ѡ���������
			men_view.setSelected(true);
			women_view.setSelected(false);
			break;
		case R.id.women_view:
			//ѡ�����Ů��
			men_view.setSelected(false);
			women_view.setSelected(true);
			break;
			
		case R.id.sure_login:
			//����ע��--�������������
			Intent intent_chat = new Intent(RegisterActivity.this,
					MessageActivity.class);
			startActivity(intent_chat);
			
			break;
			
		case R.id.ed_username:
			//ע����û���
			
			break;
			
		case R.id.ed_password:
			//ע�������
			
			break;

		}
	}

	// ���ͷ��
	private void AddHeadImage() {
		// ��xml�����ļ��ӵײ�����
		final AlertDialog dlg = new AlertDialog.Builder(this).create();
		dlg.show();// ��Ҫ����ǰ��
		Window window = dlg.getWindow();
		window.setGravity(Gravity.BOTTOM);
		window.setContentView(R.layout.add_head);
		WindowManager.LayoutParams layparam = window.getAttributes();
		layparam.width = getWindowManager().getDefaultDisplay().getWidth();
		window.setAttributes(layparam);

		// ���������ѡͼƬ��ͷ���Button��Ӽ���
		window.findViewById(R.id.camera_native).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View view) {
						// ���������ѡ��ť����
						dlg.dismiss();

						Intent galleryIntent = new Intent(
								Intent.ACTION_GET_CONTENT);
						galleryIntent.addCategory(Intent.CATEGORY_OPENABLE);
						galleryIntent.setType("image/*");
						startActivityForResult(galleryIntent,
								IMAGE_REQUEST_CODE);

					}
				});

		// ��������ѡͼƬ��ͷ���Button��Ӽ���
		window.findViewById(R.id.camera_pho).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// ���������ѡ��ť����
						dlg.dismiss();

						if (isSdcardExisting()) {
							Intent cameraIntent = new Intent(
									"android.media.action.IMAGE_CAPTURE");
							cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
									getImageUri());
							cameraIntent.putExtra(
									MediaStore.EXTRA_VIDEO_QUALITY, 0);
							startActivityForResult(cameraIntent,
									CAMERA_REQUEST_CODE);
						} else {
							Toast.makeText(arg0.getContext(), "�����sd��",
									Toast.LENGTH_LONG).show();
						}

					}
				});

		// //��ȡ����ť��Ӽ���
		window.findViewById(R.id.notBtn).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// //���������ѡ��ť������ȡ����ť��
						dlg.dismiss();
					}
				});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (resultCode != RESULT_OK) {
			return;
		} else {
			switch (requestCode) {
			case IMAGE_REQUEST_CODE:
				resizeImage(data.getData());
				break;
			case CAMERA_REQUEST_CODE:
				if (isSdcardExisting()) {
					resizeImage(getImageUri());
				} else {
					Toast.makeText(RegisterActivity.this, "δ�ҵ��洢�����޷��洢��Ƭ��",
							Toast.LENGTH_LONG).show();
				}
				break;

			case RESIZE_REQUEST_CODE:
				if (data != null) {
					showResizeImage(data);
				}
				break;
			}
		}

		super.onActivityResult(requestCode, resultCode, data);
	}

	private boolean isSdcardExisting() {
		final String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}

	public void resizeImage(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 170);
		intent.putExtra("outputY", 170);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, RESIZE_REQUEST_CODE);
	}

	private void showResizeImage(Intent data) {
		Bundle extras = data.getExtras();
		if (extras != null) {
			Bitmap photo = extras.getParcelable("data");
			
			
			
			 Bitmap output = Bitmap.createBitmap(photo.getWidth(), photo.getHeight(), Config.ARGB_8888);
		        Canvas canvas = new Canvas(output);

		        final Paint paint = new Paint();
		        //��֤�Ƿ��Σ����Ҵ����Ļ�
		        int width = photo.getWidth();
		        int height = photo.getHeight();
		        int w;
		        int deltaX = 0;
		        int deltaY = 0;
		        if (width <= height) {
		            w = width;
		            deltaY = height - w;
		        } else {
		            w = height;
		            deltaX = width - w;
		        }
		        final Rect rect = new Rect(deltaX, deltaY, w, w);
		        final RectF rectF = new RectF(rect);

		        paint.setAntiAlias(true);
		        canvas.drawARGB(0, 0, 0, 0);
		        //Բ�Σ�����ֻ��һ��
		        
		        int radius = (int) (Math.sqrt(w * w * 2.0d) / 2);
		        canvas.drawRoundRect(rectF, radius, radius, paint);

		        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		        canvas.drawBitmap(photo, rect, rect, paint);
			
			
			
			Drawable drawable = new BitmapDrawable(output);
			mImageHeader.setImageDrawable(drawable);
		}
	}

	private Uri getImageUri() {
		return Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
				IMAGE_FILE_NAME));
	}
}
