public class welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        CircleImageView ci = findViewById(R.id.avatar);

        String path = Environment.getExternalStorageDirectory().toString() + "/w65/icon_bitmap/";
        File dirFile = new File(path);
        if(!dirFile.exists()) {
            ci.setImageResource(R.mipmap.ava_guest);
        } else {
            File myIconFile= new File(path + "ava.jpg");
            ci.setImageURI(Uri.fromFile(myIconFile));
        }

        Utility.setShowAnimation(ci, 1500);
        TextView tv = findViewById(R.id.welcometxt);
        Utility.setShowAnimation(tv, 1500);

        startMainActivity();
    }

    private void startMainActivity(){

        TimerTask delayTask = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(welcome.this,MainActivity.class);
                startActivity(mainIntent);
                welcome.this.finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(delayTask,2000);//延时两秒执行 run 里面的操作
    }
}