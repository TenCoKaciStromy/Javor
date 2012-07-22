package com.tcks.javor;

import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.lang.reflect.*;

public class MainActivity extends ActivityEx
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		this.initControls();
    }
	
	
	
	private void initControls(){
		this.init_Self();
		this.init_tracer();
		this.init_pnlMainToolBar();
		this.init_pnlMainSplitter();
		this.init_pnlMainLeft();
		this.init_pnlTrace();
		this.init_txtSqlEdit();
		this.init_lstTypes();
	}
	
	private void init_Self(){

	}
	
	private Tracer tracer;
	private TextView txtTrace;
	private void init_tracer(){
		final MainActivity self = this;
		this.txtTrace = (TextView)this.findViewById(R.id.txtTrace);
		this.txtTrace.setBackgroundColor(Color.BLUE);
		
		this.tracer = new Tracer(){
			public void traceInternal(String str){
				self.trace(str);
			}
		};
	}
	
	private LinearLayout pnlMainToolBar;
	private Button btnExit;
	private void init_pnlMainToolBar() {
		final MainActivity self = this;
		UIHelper ui = this.getUIHelper();

		this.pnlMainToolBar = (LinearLayout)this.findViewById(R.id.pnlMainToolBar);

		this.btnExit = ui.newButton("EXIT");
		ui.addCtl(this.pnlMainToolBar, this.btnExit);
		this.btnExit.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					System.exit(0);
				}
			});

		Button btnMsgBoxInfo = ui.newButton("MsgBoxInfo", new View.OnClickListener(){
				public void onClick(View v){
					self.getUIHelper()
						.msgBoxInfo("my title", "my text");
				}
			});
		ui.addCtl(this.pnlMainToolBar, btnMsgBoxInfo);


	}
	
	private EditText txtSqlEdit;
	private void init_txtSqlEdit(){
		this.txtSqlEdit = (EditText)this.findViewById(R.id.txtSqlEdit);
		this.txtSqlEdit.setBackgroundColor(Color.WHITE);
		this.txtSqlEdit.setTextColor(Color.BLACK);
		this.txtSqlEdit.setGravity(Gravity.TOP);
	}
	
	private LinearLayout pnlMainSpliter;
	private void init_pnlMainSplitter(){
		this.pnlMainSpliter = (LinearLayout)this.findViewById(R.id.pnlMainSpliter);
	}
	
	private LinearLayout pnlMainLeft;
	private HorizontalDockedLinearLayoutOperator opMainLeftPanel;
	private void init_pnlMainLeft(){
		this.pnlMainLeft = (LinearLayout)this.findViewById(R.id.pnlMainLeft);
		
		this.opMainLeftPanel = new HorizontalDockedLinearLayoutOperator();
		this.opMainLeftPanel.setDockedLayout(this.pnlMainLeft);
		this.opMainLeftPanel.setTracer(this.tracer);

		this.opMainLeftPanel
			.createOperationButtons(this)
			.addTo(this.pnlMainToolBar);
	}
	
	private LinearLayout pnlTrace;
	private VerticalDockedLinearLayoutOperator opTrace;
	private void init_pnlTrace(){
		this.pnlTrace = (LinearLayout)this.findViewById(R.id.pnlTrace);
		this.opTrace = new VerticalDockedLinearLayoutOperator(this.pnlTrace);
		this.opTrace.setTracer(this.tracer);
		this.opTrace.createOperationButtons(this)
			.addGroupTo(this.pnlMainToolBar);
	}
	
	private ListView lstTypes;
	private Button btnReloadTypes;
	private void init_lstTypes(){
		this.lstTypes = (ListView)this.findViewById(R.id.lstTypes);
		
		trace("asdfasdfasf");
		UIHelper ui = this.getUIHelper();
		this.btnReloadTypes = ui.newButton("LoadTypes"
			, new SafeViewOnClickListener(){
				public void safeOnClick(View v){
					reloadTypes();
				}
			});
			
		this.pnlMainToolBar.addView(this.btnReloadTypes);
	}
	
	private void reloadTypes(){
		StringBuilder sb = new StringBuilder();
		Class<?> cls = lstTypes.getClass();
		sb.append(cls.getName())
			.append("\n");
			
		Field[] fields = cls.getFields();
		for(Field f : fields){
			sb.append("\t")
				.append(f.getName())
				.append(":")
				.append(f.getType().getName())
				.append("\n");
		}
		
		clearTrace();
		trace(sb.toString());
		
		ReflectionFieldAdapter adpFields
			= new ReflectionFieldAdapter(fields);
		
		this.lstTypes.setAdapter(adpFields);
	}
	
	private void clearTrace(){
		this.txtTrace.setText("");
	}
	private void trace(String str) {
		this.txtTrace.append(str);
		this.txtTrace.append("\n");
	}
}
