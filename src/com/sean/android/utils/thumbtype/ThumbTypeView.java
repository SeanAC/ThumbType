package com.sean.android.utils.thumbtype;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class ThumbTypeView extends View {

	private Context cnxt;
	private WindowManager wm;
	private Display disp;
	
	private Point screenSize = new Point();
	
	private ShapeDrawable leftControl;
	private Rect leftControlBounds;
	
	private ShapeDrawable rightControl;
	private Rect rightControlBounds;
	
	public ThumbTypeView(Context context) {
		super(context);
		initialize(context);
	}
	
	public ThumbTypeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}

	public ThumbTypeView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(context);
	}

	private void initialize(Context context) {
		cnxt = context;
		getDisplayParameters();
		initializeGraphicsObjects();
	}
	
	private void getDisplayParameters() {
		wm = (WindowManager) cnxt.getSystemService(Context.WINDOW_SERVICE);
		disp = wm.getDefaultDisplay();
		disp.getSize(screenSize);
	}
	
	private void initializeGraphicsObjects() {
		initializeLeftControl();
		initializeRightControl();
	}

	private void initializeLeftControl() {
		leftControl = new ShapeDrawable(new OvalShape());
		leftControl.getPaint().setColor(0xFF0055FF);
		int left = screenSize.x / 20;
		int bottom = screenSize.x / 20 * 19;
		int diameter = 100;
		leftControlBounds = new Rect(left, bottom - diameter, left + diameter, bottom);
		leftControl.setBounds(leftControlBounds);
	}

	private void initializeRightControl() {
		rightControl = new ShapeDrawable(new OvalShape());
		rightControl.getPaint().setColor(0xFF0055FF);
		int right = screenSize.x / 20 * 19;
		int bottom = screenSize.x / 20 * 19;
		int diameter = 100;
		rightControlBounds = new Rect(right - diameter, bottom - diameter, right + diameter, bottom);
		rightControl.setBounds(rightControlBounds);
	}

	@Override
	public void onDraw(Canvas canvas) {
		leftControl.draw(canvas);
		rightControl.draw(canvas);
	}
	
}
