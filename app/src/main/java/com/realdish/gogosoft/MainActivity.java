    package com.realdish.gogosoft;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.constraintlayout.widget.ConstraintLayout;

    import android.animation.AnimatorSet;
    import android.animation.ObjectAnimator;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.TextView;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            getSupportActionBar().hide();

            ConstraintLayout constraintLayout = findViewById(R.id.ConstraintLayout);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.activity_instrucoes);

                }
            });

            startAnimation();

        }

        private void startAnimation() {
            TextView textView = findViewById(R.id.toqueComecar);

            // Define a animação de escala
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(textView, "scaleX", 1.0f, 1.1f);
                scaleX.setDuration(3000);
            scaleX.setRepeatCount(ObjectAnimator.INFINITE);
            scaleX.setRepeatMode(ObjectAnimator.REVERSE);

            // Define a animação de escala vertical
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(textView, "scaleY", 1.0f, 1.1f);
            scaleY.setDuration(3000);
            scaleY.setRepeatCount(ObjectAnimator.INFINITE);
            scaleY.setRepeatMode(ObjectAnimator.REVERSE);

            // Define a animação de opacidade
            ObjectAnimator alpha = ObjectAnimator.ofFloat(textView, "alpha", 1.0f, 0.2f);
            alpha.setDuration(3000);
            alpha.setRepeatCount(ObjectAnimator.INFINITE);
            alpha.setRepeatMode(ObjectAnimator.REVERSE);

            // Cria o conjunto de animações
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(scaleX, scaleY, alpha);
            animatorSet.start();
        }
    }